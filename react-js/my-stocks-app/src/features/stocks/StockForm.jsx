import React, { useContext, useState } from 'react'
import { useDispatch } from 'react-redux';
import { saveStock } from './stocksApi';




const StockForm = () => {

  const dispatch = useDispatch();
  const [stockForm,setForm]=useState({name:"",companyName:"",price:0})
  const [errors, setErrors] = useState({});

  function validate(){
    const errs = {}
    if(!stockForm.name.trim()) errs.name= 'Stocks name required'
    return errs;
  }

  function handleChange(e){
    const {name, value} = e.target;
    setForm(prev => ({...prev, [name]:value}))
  }


  function handleSubmit(e){
    e.preventDefault();
    const validationErrors = validate();
    setErrors(validationErrors)
    if(Object.keys(validationErrors).length === 0){
      saveStock(stockForm);
      alert('Stock added successfully')
      setForm({name:"",companyName:"",price:0})
    }
  }

  return (
    <form onSubmit={handleSubmit} className='mb-3'>
        <div className='mb-3'>
            <label className='form-label'>Stock Name</label>
            <input type="text" className='form-control' name='name' value={stockForm.name} onChange={handleChange} />
            {errors.name && <span className='text-danger'>{errors.name}</span>}
        </div>
        <div className='mb-3'>
            <label className='form-label'>Company Name</label>
            <input type="text" className='form-control' name='companyName' value={stockForm.companyName} onChange={handleChange} />
        </div>
        <div className='mb-3'>
            <label className='form-label'>Price</label>
            <input type="number" className='form-control' name='price' value={stockForm.price} onChange={handleChange} />
        </div>
        <button type="submit" className='btn btn-primary'>Add Stock</button>
    </form>
  )
}

export default StockForm