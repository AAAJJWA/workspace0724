import React, { forwardRef } from "react";

const YugiohCard = forwardRef(({ inputValues }, ref) => {
  return (
    <div ref={ref} className="w-[750px] h-auto aspect-[7/10] relative">

      {/* ===== 카드 중앙 이미지 ===== */}
      <div
        style={{ backgroundImage: `url(${inputValues.artwork})` }}
        className="object-fit bg-center bg-cover select-none absolute rounded-[2px] top-[189px] left-[85px] w-[580px] h-[570px]"
      ></div>

      {/* ===== 카드 템플릿 PNG ===== */}
      <img
        src={`/yugioh/cards/${inputValues.yugiohTemplate}.png`}
        className="select-none absolute top-0 left-0 right-0 bottom-0 h-full w-full object-fit"
        alt="card template"
      />

      {/* ===== 속성 아이콘 ===== */}
      <img
        src={
          inputValues.yugiohTemplate === "spell"
            ? "/yugioh/icons/spell.png"
            : inputValues.yugiohTemplate === "trap"
            ? "/yugioh/icons/trap.png"
            : `/yugioh/icons/${inputValues.yugiohElement}.png`
        }
        alt="element icon"
        className="select-none absolute top-[48px] right-[50px]"
      />

      {/* ===== 카드 이름 ===== */}
      <div
        style={{ lineHeight: "85px" }}
        className="select-none absolute top-[36px] left-[58px] font-ygo-matrix-sc-2 text-[84px]"
      >
        {inputValues.name}
      </div>

      {/* ===== 레벨 ===== */}
      {inputValues.yugiohTemplate !== "spell" &&
        inputValues.yugiohTemplate !== "trap" && (
          <div className="absolute flex flex-row top-[126px] right-[74px] gap-0.5">
            {Array.from({ length: inputValues.yugiohLevel }, (_, index) => (
              <div
                key={index}
                className="w-[49px] h-auto aspect-[1/1] bg-cover bg-center"
                style={{
                  backgroundImage: `url("/yugioh/icons/level.png")`,
                }}
              ></div>
            ))}
          </div>
        )}

      {/* ===== SPELL / TRAP 타입 표시 ===== */}
      {(inputValues.yugiohTemplate === "spell" ||
        inputValues.yugiohTemplate === "trap") && (
        <div className="select-none absolute top-[113px] right-[68px] font-ygo-stone-serif-sc-bold text-[41.75px]">
          [{inputValues.yugiohTemplate} Card]
        </div>
      )}

      {/* ===== 카드 타입 ===== */}
      {inputValues.yugiohTemplate !== "spell" &&
      inputValues.yugiohTemplate !== "trap" ? (
        <div className="absolute top-[803px] left-[58px] text-[28px] font-ygo-stone-serif-sc-bold">
          [{inputValues.yugiohCardType}]
        </div>
      ) : null}

      {/* Edition / Card Number */}
      <div className="absolute left-[82px] bottom-[270px] text-[30px] font-ygo-matrix-sc-2">
        {inputValues.yugiohEdition}
      </div>
      <div className="absolute right-[82px] bottom-[270px] text-[30px] font-ygo-matrix-sc-2">
        {inputValues.yugiohCardNumber}
      </div>

      {/* ===== Effect 텍스트 ===== */}
      <div
        className={
          "absolute left-[58px] right-[56px] text-[22.25px] leading-[22.25px] font-ygo-matrix-book " +
          (inputValues.yugiohTemplate === "spell" ||
          inputValues.yugiohTemplate === "trap"
            ? "top-[810px]"
            : "top-[845px]")
        }
      >
        {inputValues.yugiohEffect}
      </div>

      {/* ATK / DEF */}
      {inputValues.yugiohTemplate !== "spell" &&
      inputValues.yugiohTemplate !== "trap" ? (
        <>
          <div className="absolute bottom-[62px] right-[212px] text-[26px] font-ygo-stone-serif-sc-bold">
            ATK/{inputValues.yugiohAttack}
          </div>
          <div className="absolute bottom-[62px] right-[57px] text-[26px] font-ygo-stone-serif-sc-bold">
            DEF/{inputValues.yugiohDefense}
          </div>
        </>
      ) : null}

      {/* Identifier */}
      <div className="select-none absolute bottom-[17px] right-[315px] left-[36px] font-ygo-matrix-sc-2 text-[32px] overflow-hidden whitespace-nowrap">
        {inputValues.yugiohIdentifier}
      </div>

      {/* Copyright */}
      <div className="select-none absolute bottom-[17px] right-[60px] left-[315px] font-ygo-matrix-sc-2 text-[32px] text-right flex gap-1.5 justify-end">
        <span className="text-[24px] font-serif">©</span>
        {inputValues.yugiohCopyright}
      </div>

      {/* Seal 아이콘 */}
      <div
        style={{ backgroundImage: `url("/yugioh/icons/seal.png")` }}
        className="object-fit bg-center bg-cover select-none absolute rounded-[2px] bottom-[50px] right-[50px] w-[24px] h-[24px]"
      ></div>
    </div>
  );
});

export default YugiohCard;
