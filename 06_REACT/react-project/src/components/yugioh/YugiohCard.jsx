import React, { useEffect, useRef } from "react";

const CARD_WIDTH = 725;
const CARD_HEIGHT = 1040;

export default function YugiohCard({ inputValues }) {
  const canvasRef = useRef(null);

  useEffect(() => {
    const canvas = canvasRef.current;
    canvas.width = CARD_WIDTH;
    canvas.height = CARD_HEIGHT;

    const ctx = canvas.getContext("2d");

    // 렌더링 시작
    drawCard(ctx, inputValues);
  }, [inputValues]);

  return (
    <canvas
      ref={canvasRef}
      style={{
        width: "360px", // 화면에는 축소된 크기로 보이게
        height: (360 * CARD_HEIGHT) / CARD_WIDTH + "px",
        borderRadius: "12px",
        background: "#000",
      }}
    ></canvas>
  );
}

/* ============================================================================================
   ⬇⬇⬇ 카드 그리기
============================================================================================= */
function drawCard(ctx, values) {
  ctx.clearRect(0, 0, CARD_WIDTH, CARD_HEIGHT);

  // 1. 템플릿 로드
  loadImage(`/yugioh/cards/${values.yugiohTemplate}.png`).then((template) => {
    ctx.drawImage(template, 0, 0, CARD_WIDTH, CARD_HEIGHT);

    /* -----------------------------------------------------
       2. Artwork (정확한 템플릿 좌표 적용)
       ----------------------------------------------------- */
    if (values.artwork) {
      loadImage(values.artwork).then((img) => {
        ctx.drawImage(img, 86.5, 189, 555, 545);
      });
    }

    /* -----------------------------------------------------
       3. 속성 아이콘
       ----------------------------------------------------- */
    const iconSrc =
      values.yugiohTemplate === "spell"
        ? "/yugioh/icons/spell.png"
        : values.yugiohTemplate === "trap"
        ? "/yugioh/icons/trap.png"
        : `/yugioh/icons/${values.yugiohElement}.png`;

    loadImage(iconSrc).then((icon) => {
      ctx.drawImage(icon, 610, 40, 72, 72); // 템플릿 기준 정확 좌표
    });

    /* -----------------------------------------------------
       4. 카드 이름
       ----------------------------------------------------- */
    drawText(ctx, values.name, 46, 100, "60px ygo-matrix-sc-2", "#000");

    /* -----------------------------------------------------
       5. 레벨
       ----------------------------------------------------- */
    if (values.yugiohTemplate !== "spell" && values.yugiohTemplate !== "trap") {
      loadImage("/yugioh/icons/level.png").then((star) => {
        const startX = 610;          
        const spacing = 52;

        for (let i = 0; i < values.yugiohLevel; i++) {
          ctx.drawImage(star, startX - i * spacing, 122, 49, 49);
        }
      });
    }

    /* -----------------------------------------------------
       6. Spell/Trap 카드 타입 텍스트
       ----------------------------------------------------- */
    if (["spell", "trap"].includes(values.yugiohTemplate)) {
      drawText(
        ctx,
        `[${values.yugiohTemplate.toUpperCase()} CARD]`,
        450,
        160,
        "34px ygo-stone-serif-sc-bold",
        "#000"
      );
    }

    /* -----------------------------------------------------
       7. 몬스터 타입 텍스트
       ----------------------------------------------------- */
    if (!["spell", "trap"].includes(values.yugiohTemplate)) {
      drawText(
        ctx,
        `[${values.yugiohCardType}]`,
        50,
        810,
        "28px ygo-stone-serif-sc-bold",
        "#000"
      );
    }

    /* -----------------------------------------------------
       8. Edition
       ----------------------------------------------------- */
    drawText(
      ctx,
      values.yugiohEdition,
      70,
      765,
      "24px ygo-matrix-sc-2",
      "#000"
    );

    /* -----------------------------------------------------
       9. 카드 번호
       ----------------------------------------------------- */
    drawText(
      ctx,
      values.yugiohCardNumber,
      655,
      765,
      "24px ygo-matrix-sc-2",
      "#000",
      "right"
    );

    /* -----------------------------------------------------
       10. 카드 효과 줄바꿈
       ----------------------------------------------------- */
    drawMultilineText(
      ctx,
      values.yugiohEffect,
      50,
      840,
      620, // max width
      28,  // line height
      "24px ygo-matrix-book"
    );

    /* -----------------------------------------------------
       11. ATK / DEF
       ----------------------------------------------------- */
    if (!["spell", "trap"].includes(values.yugiohTemplate)) {
      drawText(
        ctx,
        `ATK/${values.yugiohAttack}`,
        410,
        972,
        "28px ygo-stone-serif-sc-bold",
        "#000"
      );

      drawText(
        ctx,
        `DEF/${values.yugiohDefense}`,
        670,
        972,
        "28px ygo-stone-serif-sc-bold",
        "#000",
        "right"
      );
    }

    /* -----------------------------------------------------
       12. Identifier
       ----------------------------------------------------- */
    drawText(
      ctx,
      values.yugiohIdentifier,
      35,
      1010,
      "24px ygo-matrix-sc-2",
      "#000"
    );

    /* -----------------------------------------------------
       13. Copyright
       ----------------------------------------------------- */
    drawText(
      ctx,
      `© ${values.yugiohCopyright}`,
      670,
      1010,
      "24px ygo-matrix-sc-2",
      "#000",
      "right"
    );
  });
}



/* ============================================================================================
   이미지 로더
============================================================================================= */
function loadImage(src) {
  return new Promise((res) => {
    const img = new Image();
    img.crossOrigin = "anonymous";
    img.onload = () => res(img);
    img.src = src;
  });
}

/* ============================================================================================
   텍스트 출력 함수
============================================================================================= */
function drawText(ctx, text, x, y, font, color, align = "left") {
  ctx.font = font;
  ctx.fillStyle = color;
  ctx.textAlign = align;
  ctx.fillText(text, x, y);
}

/* ============================================================================================
   줄바꿈 텍스트 출력
============================================================================================= */
function drawMultilineText(ctx, text, x, y, maxWidth, lineHeight, font) {
  ctx.save();
  ctx.font = font;
  ctx.fillStyle = "#000";
  ctx.textAlign = "left";

  let line = "";
  let currentY = y;

  for (let char of text) {
    const testLine = line + char;
    const metrics = ctx.measureText(testLine);

    if (metrics.width > maxWidth) {
      ctx.fillText(line, x, currentY);
      line = char;
      currentY += lineHeight;
    } else {
      line = testLine;
    }
  }
  ctx.fillText(line, x, currentY);
  ctx.restore();
}
