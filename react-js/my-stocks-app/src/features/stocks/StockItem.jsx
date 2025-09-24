import React from 'react'
import { Button, Card, Col, Container } from 'react-bootstrap'

const StockItem = ({stock,deleteStock}) => {
  return (
    <Col key={stock.id} md={4}>
    <Card className='mb-3'>
        <Card.Body>
            <Card.Title>{stock.name}</Card.Title>
            <Card.Text>
                Price: ${stock.price} <br />
                Company: {stock.companyName}
                <Container>
                <Button variant="primary" className='mt-2'>Update</Button>
                <Button variant="danger" className='mt-2 ms-2' onClick={()=>deleteStock(stock.id)}>Delete</Button>
                </Container>
            </Card.Text>
        </Card.Body>
    </Card>
</Col>
  )
}

export default StockItem