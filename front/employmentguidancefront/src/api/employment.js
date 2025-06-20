import request from '@/utils/request'

export const addEmployment = data => request.post('/addEmployment', data)

export const findAllEmployment = data => request.get('/findAllEmployment')

export const deleteEmployment = data => request.post('/deleteEmployment', data)
export const updateEmployment = data => request.post('/updateEmployment', data)