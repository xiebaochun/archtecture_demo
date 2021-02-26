import * as Types from '../constants/actionTypes'
import * as R from 'ramda'
import { login, fetchThings } from './common'

export function students(state = {
	data: {},
	status: '',
}, action) {
	let { type } = action
	switch (type) {
		case Types.GET_ALL_STUDENTS: 
			return fetchThings(state, action);
		default: return state
	}
}