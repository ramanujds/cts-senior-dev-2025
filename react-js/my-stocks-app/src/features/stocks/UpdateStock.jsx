import React, { use, useContext, useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router';
import { StockContext } from '../../App';
import { fetchStockById } from './stocksApi';



const UpdateStock = () => {

    const {id} = useParams(); 
    const {state, dispatch} = useContext(StockContext);
    const [stockForm,setForm]=useState({name:"",companyName:"",price:0})
    const [errors, setErrors] = useState({});
    const navigate = useNavigate();




    useEffect(() => {
        fetchStockById(id).then(data => {
            setForm(data);
        }).catch(error => {
            console.error('Error fetching stock by ID:', error);
        });
    }, [id]);
  
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
      console.log(stockForm);
      const validationErrors = validate();
      setErrors(validationErrors)
      if(Object.keys(validationErrors).length === 0){
        dispatch({type: 'UPDATE', payload: stockForm})
        alert('Stock updated successfully')
        navigate('/');
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

export default UpdateStock