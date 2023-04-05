const Employee = ({ employee }) => {
  return (
    <tr key={employee.id}>
      <td className='text-left px-6 px-4 whitespace-nowrap'>
        <div className='text-sm text-gray-500'>{employee.firstName}</div>
      </td>
      <td className='text-left px-6 px-4 whitespace-nowrap'>
        <div className='text-sm text-gray-500'>{employee.lastName}</div>
      </td>
      <td className='text-left px-6 px-4 whitespace-nowrap'>
        <div className='text-sm text-gray-500'>{employee.emailId}</div>
      </td>
      <td className='text-right px-6 px-4 whitespace-nowrap font-medium text-sm'>
        <div className='text-sm text-gray-500'>
          <a href='#' className='text-indigo-600 hover:text-indigo-800 px-4'>
            Edit
          </a>
          <a href='#' className='text-gray-60 hover:text-red-600 '>
            Delete
          </a>
        </div>
      </td>
    </tr>
  )
}

export default Employee
