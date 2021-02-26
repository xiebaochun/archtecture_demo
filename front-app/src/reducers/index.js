import { combineReducers } from 'redux'
import { account } from './user'
import { students } from './student'
import { reducer as reduxFormReducer } from 'redux-form'
export default combineReducers({
	students,
	account,
	form: reduxFormReducer,
})
