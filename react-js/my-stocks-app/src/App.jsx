import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Greet from './components/Greet'

export function App() {

  return (
    <>
      <h1>Hello everyone Welcome to ReactJS</h1>
      <Greet name='Rahul'/>
      <Greet name='Manish'/>
      <Greet name='Javed'/>
      <Greet name='Rohan'/>
    </>
  )
}

// export default App
