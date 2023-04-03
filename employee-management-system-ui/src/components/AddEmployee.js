const AddEmployee = () => {
  return (
    <div className='flex max-w-2xl  mx-auto shadow border-b'>
      <div className='px-8 py-8 '>
        <div className='font-thin text-2xl'>
          <h1>Add New Employee</h1>
        </div>
        <div className='items-center justify-center h-14 w-full'>
          <label className='block text-gray-600 text-sm font-normal'>
            First Name
          </label>
          <input type='text' className='h-10 w-96 border mt-2'></input>
        </div>
      </div>
    </div>
  )
}

export default AddEmployee
