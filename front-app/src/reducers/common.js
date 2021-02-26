import * as R from 'ramda';

export const [REQUEST, SUCCESS, FAILURE] = ['REQUEST', 'SUCCESS', 'FAILURE'];

const Status = {
	FETCHING: 'FETCHING',
	FETCHED: 'FETCHED',
	FETCH_FAIL: 'FETCH_FAIL'
}

export function fetchThings(state, action) {
    let { status } = action;
    switch (status) {
        case REQUEST:
            return R.merge(state, { status: Status.FETCHING });
        case SUCCESS: {
            let data = action.payload.data;
            return R.merge(state, { data, status: Status.FETCHED });
        }
        case FAILURE: {
            let error = action.error.response.data;
            return R.merge(state, { status: Status.FETCH_FAIL });
        }
        default:
            return state;
    }
}

export function login(state, action) {
	let { type } = action
	switch (type) {
        
	}
}