import request from '@/utils/request'

export const addMessage = data => request.post('/addMessage', data)

export const findMessage = data => request.post('/findMessage', data)

export const deleteMessage = data => request.post('/deleteMessage', data)

