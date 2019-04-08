import 'bootstrap/dist/css/bootstrap.min.css'
import React from 'react'
import ReactDOM from 'react-dom'
import { Alert, Button, Form, FormGroup, Label, Input, FormText, Col, Row } from 'reactstrap'

class App extends React.Component {
	constructor(props) {
		super(props)
		this.state = { textField: "" }
		this.onSubmit = this.onSubmit.bind(this)
	}
	
	onSubmit() {
		this.setState({ loading: true, result: null })
		const response = fetch('/api/scrub', { 
		    method: 'POST',
		    headers: { "Content-Type": "application/json" },
		    body: JSON.stringify({ textField: this.state.textField })
		})
		.then(res => res.json())
		.then(res => this.setState({ loading: false, result: JSON.stringify(res) }))
	}
	
	render() {
		return (
			<Row className="d-flex justify-content-center align-items-center">
				<Col xs={10} md={6}>
					<Form>
						<FormGroup>
						  <Label for="text">Text Field</Label>
						  <Input
								type="textarea"
								id="text"
								value={this.state.textField}
								onChange={e => this.setState({ textField: e.target.value })}
							/>
						</FormGroup>
						<Button disabled={this.state.loading} onClick={this.onSubmit}>
							Submit
						</Button>
					</Form>
					{this.state.result ? (
						<Alert color="dark">Response received: {this.state.result}</Alert>
					) : (
						<div />
					)}
				</Col>
			</Row>
		)
	}
}


ReactDOM.render(
	<App />,
	document.getElementById('react')
)
