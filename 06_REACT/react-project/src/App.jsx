import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Signup from './components/useState/Signup'
import LandingPage from './components/useState/LandingPage'
import UseRefTest from './components/useRef/useRefTest'
import UseRefScroll from './components/useRef/useRefScroll'
import UseMemoTest from './components/useMemo/useMemoTest'
import UseCallbackTest from './components/useCallback/useCallbackTest'
import UseEffectTest from './components/useEffect/UseEffectTest'

function App() {

  return (
    <>
      {/* <UseStateTest /> */}
      {/* <Signup /> */}
      {/* <LandingPage /> */}
      {/* <UseRefTest /> */}
      {/* <UseRefScroll /> */}
      {/* <UseMemoTest /> */}
      {/* <UseCallbackTest /> */}
      <UseEffectTest />
    </>
  )
}

export default App