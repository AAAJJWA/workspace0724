/*
    localStorage
    - 브라우저에 key-value형태로 데이터를 저장할 수 있는 공간.
    - 저장된 데이터는 브라우저를 껐다 켜도 유지가되며, 도메인별로 저장이 된다.
    - 최대 저장용량은 5MB(브라우저별로 다를 수 있음)

    localStorage.setItem(key, value); - 데이터를 저장
    localStorage.getItem(key); - 데이터를 불러올 때
    localStorage.removeItem(key); - 데이터를 삭제할 때
    localStorage.clear(); - 모든 데이터 삭제
    * 문자열만 저장하고 가져올 수 있다.

    JSON.stringify(js객체) -> JSON 문자열로 변환
    JSON.parse(문자열) -> JS객체로 복원
*/

/*
    헤더 영역: 구현O
    입력 영역: 구현O
    필터 영역: 구현X
    목록 영역: 구현O
    요약 영역: 구현O
*/

let accounts = JSON.parse(localStorage.getItem('accounts')) || [];
let filterState = 'all';
let selectedType = '';

// DOM
const pinfo = document.getElementById("price-info");    // 내용 input
const price = document.getElementById("price");     // 금액 input
const accBtns = document.querySelectorAll(".accBtns button");   // 수입, 지출 버튼
const filterBtns = document.querySelectorAll(".filter-buttons button"); // 필터 버튼들
const addBtn = document.getElementById("addBtn");   // 추가하기 버튼
const footer = document.querySelector(".footer");   // 수입, 지출 목록 ul

// 초기화 함수
function init() {
    bindEvent();    // 수정 추가
    // toggleClass();
    render();
}

// 이벤트
function bindEvent() {
    addBtn.addEventListener('click', addAccount);

    accBtns.forEach(function(btn, index) {
        btn.addEventListener("click", function() {
            accBtns.forEach(function(del) {
                del.classList.remove('selected');
            })

            btn.classList.toggle('selected');

            selectedType = (index === 0 ? "income" : "expend");
        })
    });

    filterBtns.forEach(function(btn) {
        btn.addEventListener("click", function() {
            filterBtns.forEach(function(del) {
                del.classList.remove('selected');
            })

            btn.classList.toggle('selected');
            filterState = btn.dataset.filter;
            render();
        })
    })
}

// addBtn.addEventListener('click', addAccount);

function addAccount() {
    const text1 = pinfo.value.trim();
    const text2 = price.value.trim();

    if(!text1 || !text2) return; 

    const account = {
        id: Date.now(),
        content1: text1,
        content2: text2,
        type: selectedType,
        createdAt: new Date().toLocaleDateString(),
    }

    accounts.push(account);

    pinfo.value = "";
    price.value = "";

    saveAccounts()
    render();
}

// function toggleClass() {
//     accBtns.forEach(function(btn, index) {
//         btn.addEventListener("click", function() {
//             accBtns.forEach(function(del) {
//                 del.classList.remove('selected');
//             })

//             btn.classList.toggle('selected');

//             selectedType = (index === 0 ? "income" : "expend");
//         })
//     });

//     filterBtns.forEach(function(btn) {
//         btn.addEventListener("click", function() {
//             filterBtns.forEach(function(del) {
//                 del.classList.remove('selected');
//             })

//             btn.classList.toggle('selected');
//             filterState = btn.dataset.filter;
//             render();
//         })
//     })
// }

function saveAccounts(){
    localStorage.setItem('accounts', JSON.stringify(accounts));
}

function deleteAccounts(id){
    let newAccount = [];
    for(let account of accounts){
        if(account.id === id)
            continue;

        newAccount.push(account);
    }

    accounts = newAccount;
    saveAccounts();
    render();
}

function updateAccountSum() {
    const income = document.querySelector("#income p");
    const expend = document.querySelector("#expend p");
    const balance = document.querySelector("#balance p");
    const cash = document.getElementById("cash");

    let totalIncome = 0;
    let totalExpend = 0;

    accounts.forEach(function(acc) {
        if(acc.type === "income") {
            totalIncome += Number(acc.content2);
        } else if(acc.type === "expend") {
            totalExpend += Number(acc.content2);
        }
    });

    let totalBalance = totalIncome - totalExpend;

    income.textContent = `${totalIncome.toLocaleString()}원`;
    expend.textContent = `${totalExpend.toLocaleString()}원`;
    balance.textContent = `${totalBalance.toLocaleString()}원`;
    cash.textContent = `${totalBalance.toLocaleString()}원`;
}

function getFilteredAccounts() {
    const filteredAccounts = [];
    if(filterState === 'income'){
        //미완료목록만 담김
        for(let account of accounts){
            if(account.type === 'income') {
                filteredAccounts.push(account);
            }
        }
    } else if(filterState === 'expend'){
        //완료목록만 담김
        for(let account of accounts){
            if(account.type === 'expend') {
                filteredAccounts.push(account);
            }
        }
    } else{
        return accounts;
    }

    return filteredAccounts;
} // 수정중

// 렌더링
function render() {
    footer.innerHTML = "";

    const filteredAccounts = getFilteredAccounts(); // 수정 추가

    if(filteredAccounts.length === 0) { // 수정 추가
        emptyFilterRender();
    } else {
        filteredAccounts.forEach(function(account) {
            itemRender(account);
        });
    }

    updateAccountSum();
}

function emptyFilterRender(){   // 수정 추가
   const emptyEl = document.createElement('div');
    emptyEl.className = 'empty-state';
    emptyEl.innerHTML = '항목이 없습니다.'
    accounts.appendChild(emptyEl);
}

function itemRender(account) {
    const items = document.createElement('li');
    items.className = 'items';
    items.innerHTML = `<div id="info">
                    <p id="date">${account.createdAt}</p>
                    <p>${account.content1}</p>
                </div>
                
                <span class="${account.type}">${account.type === 'income' ? '+' : '-'}${Number(account.content2).toLocaleString()}원</span>

                <button id="deleteBtn">삭제</button>`;

    const deleteBtn = items.querySelector('#deleteBtn');
    deleteBtn.addEventListener('click', function(){
        deleteAccounts(account.id);
    });

    footer.appendChild(items);
}

// 필터링
// function setFilter(filter){
//     filterState = filter; //전역상태에 필터상태를 변경

//     filterBtns.forEach(function(btn){
//         btn.className = (btn.dataset.filter === filter ? "active" : "");
//     });

//     render();
// } // 필요 없는 부분

document.addEventListener('DOMContentLoaded', init);//////