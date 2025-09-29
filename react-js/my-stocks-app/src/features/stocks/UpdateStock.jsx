import React, { use } from 'react'
import { useParams } from 'react-router';

const UpdateStock = () => {

  const {id} = useParams(); 
  return (
    <div>UpdateStock with id : {id}</div>
  )
}

export default UpdateStock