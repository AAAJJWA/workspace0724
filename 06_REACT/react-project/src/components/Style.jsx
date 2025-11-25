import React from 'react'

const roundBoxStyle = {
    position: "absolute",
    top: 50,
    left: 50,
    width: 200,
    height: 200,
    backgroundColor: "blue",
    borderRadius: 50,
}

const Style = () => {
    return (
        <>
            <h3>1. Object로 css 작성</h3>
            <p>인라인 속성이며, 재사용성이 떨어지고 코드 복잡도가 높아짐</p>
            <div style={{
                position: "relative",
                width: 400,
                height: 1500,
                backgroundColor: "#f1f1f1",
            }}>
                <h3>2_1. css-in-js 로 스타일을 직접 작성</h3>
                <div style={roundBoxStyle}>ㅎㅇ</div>
                <p>재사용이 가능하고 코드가 깔끔하다</p>
                <div>class를 활용</div>
            </div>
        </>
    )
}

export default Style