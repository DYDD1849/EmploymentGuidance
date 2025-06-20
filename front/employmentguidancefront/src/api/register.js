import request from '@/utils/request'

export const StudentRegister = data => request.post('/StudentRegister', data)

export const EnterpriseRegister = data => request.post('/EnterpriseRegister', data)

