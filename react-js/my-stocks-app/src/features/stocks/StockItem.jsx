import React, { use } from 'react'
import { Button, Card, Col, Container } from 'react-bootstrap'
import { useNavigate } from 'react-router';

import { useDispatch } from 'react-redux';

const StockItem = ({stock}) => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  function handleUpdate(id) {
      navigate('/update/'+id);
  }

  return (
    <Col key={stock.id} md={4}>
    <Card className='mb-3'>
        <Card.Body>
            <Card.Title>{stock.name}</Card.Title>
            <Card.Text>
                Price: ${stock.price} <br />
                Company: {stock.companyName}
                <Container>
                <Button variant="primary" className='mt-2' onClick={()=>handleUpdate(stock.id)} >Update</Button>
                <Button variant="danger" className='mt-2 ms-2' onClick={()=>dispatch({type: 'DELETE', payload: stock.id})}>Delete</Button>
                </Container>
            </Card.Text>
        </Card.Body>
    </Card>
</Col>
  )
}

export default StockItem