import request from '@/utils/request'

export const addStudent = data => request.post('/addStudent', data)
export const deleteStudent = data => request.post('/deleteStudent', data)
export const updateStudent = data => request.post('/updateStudent', data)
export const findAllStudent = data => request.get('/findAllStudent')
