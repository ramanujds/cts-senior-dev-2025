import React, { useContext, useState } from 'react'
import { StockContext } from '../../App'
import { useForm } from 'react-hook-form';

const StockReactHookFormBased = () => {
  const dispatch = useContext(StockContext).dispatch;

  // Use the useForm hook to manage form state and methods
  const {
    register, // A function to register inputs
    handleSubmit, // The function that handles form submission
    reset, // A function to clear the form
    formState: { errors } // Object containing form errors
  } = useForm({
    // Set default values for the form fields
    defaultValues: {
      name: "",
      companyName: "",
      price: 0
    }
  });

  // This function is called by handleSubmit if validation passes
  function onSubmit(data) {
    dispatch({ type: 'ADD', payload: data });
    alert('Stock added successfully');
    reset(); // Clear the form fields after successful submission
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)} className='mb-3'>
      <div className='mb-3'>
        <label className='form-label'>Stock Name</label>
        <input 
          type="text" 
          className='form-control' 
          {...register('name', { required: 'Stock name is required' })} 
        />
        {errors.name && <span className='text-danger'>{errors.name.message}</span>}
      </div>
      
      <div className='mb-3'>
        <label className='form-label'>Company Name</label>
        <input 
          type="text" 
          className='form-control' 
          {...register('companyName')} 
        />
      </div>
      
      <div className='mb-3'>
        <label className='form-label'>Price</label>
        <input 
          type="number" 
          className='form-control' 
          {...register('price')} 
        />
      </div>
      
      <button type="submit" className='btn btn-primary'>Add Stock</button>
    </form>
  );
};

export default StockReactHookFormBased;


