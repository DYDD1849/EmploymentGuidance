import request from '@/utils/request'

export const findAllRecruit = data => request.get('/findAllRecruit')

export const findRecruitByPosition = data => request.post('/findRecruitByPosition', data)

export const addRecruit = data => request.post('/addRecruit', data)


export const findRecruitByEnterprise = data => request.post('/findRecruitByEnterprise', data)

export const updateRecruit = data => request.post('/updateRecruit', data)

export const deleteRecruit = data => request.post('/deleteRecruit', data)
