import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'
import { Link } from 'react-router-dom'

const Header = () => {
  return (
    <Navbar bg="dark" variant="dark">
        <Container>
            <Navbar.Brand href="#">My Stocks App</Navbar.Brand>
            <Nav>
               <Link to="/" className="nav-link">Home</Link>
               <Link to="/add-stock" className="nav-link">Add Stock</Link>
                <Link to="/login" className="nav-link">Login</Link>
            </Nav>
        </Container>
    </Navbar>
  )
}

export default Header