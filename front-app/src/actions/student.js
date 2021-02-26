import * as Types from '../constants/actionTypes'
import * as R from 'ramda'
import { getDefaultHeaders } from './utils'

export function getAllStudents(headers = {}) {
	return {
		type: Types.GET_ALL_STUDENTS,
		payload: {
			request: {
				method: 'get',
				url: `student/getAll`,
				
				headers: R.merge(getDefaultHeaders(), headers),
				responseType: 'json'
			}
		}
	}
}