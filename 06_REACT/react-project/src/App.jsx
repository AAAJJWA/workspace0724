import { useState } from 'react'
import JavaScript from './components/JavaScript'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Product from './components/Product'
import styled from 'styled-components'

const products = [{
  product
}]

const Table = styled.table`
  width: 100%;
  border-collapse: collapse;
`

const Th = styled.th`
  background: #8a8a8a;
  color: white;
  padding: 12px;
  border: 1px solid #afafaf;
`

const Tr = styled.tr`

`

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      { /* <JavaScript /> */ }
      {/* <Style /> */ }

      <Table>
        <Thead>
          <tr>
            <Th>제품명</Th>
            <Th>가격</Th>
            <Th>색상</Th>
          </tr>
        </Thead>
        <tbody>
          {products.map(p => <Product product={p}/>)}
          <Product />
        </tbody>
      </Table>
    </>
  )
}

export default App
