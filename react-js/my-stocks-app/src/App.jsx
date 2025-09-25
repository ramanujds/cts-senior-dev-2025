import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Header from './pages/Header'
import MainPage from './pages/MainPage'
import Footer from './pages/Footer'
import { Col, Row } from 'react-bootstrap'

export function App() {

  return (
    <>
    
     <Header />
     <main>
      <MainPage />
     </main>
    
     <Footer />
    
    </>
  )
}

// export default App
