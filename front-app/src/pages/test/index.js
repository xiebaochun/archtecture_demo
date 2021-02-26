import React from 'react'
import * as R from 'ramda'
import { connect } from 'react-redux'
import { Route, BrowserRouter, Switch } from 'react-router-dom'
import Form from './form'
import Demo from './Demo'

import { Table, Form as _Form, Icon, Input, Button, Checkbox } from 'antd';

import { getAllStudents } from '../../actions/student'


class Test extends React.Component{
	componentDidMount() {
		this.props.dispatch(getAllStudents())
	}
	render() {
		const match = this.props.match
		const dataSource = !R.isEmpty(this.props.students.data) && this.props.students.data || [];
		const columns = [
			{
			    title: '序号',
			    dataIndex: 'id',
			    key: 'id',
			  },
			  {
			    title: 'first name',
			    dataIndex: 'firstName',
			    key: 'firstName',
			  },
			  {
			    title: 'last name',
			    dataIndex: 'lastName',
			    key: 'lastName',
			  },
		]
		return <div>
					<div>
						<Table dataSource={dataSource} columns={columns} />;
					</div>
	                <Switch>
	                    <Route path={`${match.url}/form`} name="Login Page" component={Form}/>
	                    <Route path={`${match.url}/demo`} name="Login Page" component={Demo}/>
	                </Switch>
				</div>
	}
}


export default connect((state) => {
	return {
		students: state.students
	}
})(Test)
 