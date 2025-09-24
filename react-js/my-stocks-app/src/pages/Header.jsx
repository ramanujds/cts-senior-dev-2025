import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'

const Header = () => {
  return (
    <Navbar bg="dark" variant="dark">
        <Container>
            <Navbar.Brand href="#">My Stocks App</Navbar.Brand>
            <Nav>
                <Nav.Link href="#">Home</Nav.Link>
                <Nav.Link href="#">Stocks</Nav.Link>
                <Nav.Link href="#">About</Nav.Link>
            </Nav>
        </Container>
    </Navbar>
  )
}

export default Header