import React, { useState, useEffect } from 'react';
import {Link} from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';

const ListEmployeeComponent = () => {
    const[employees, setEmployees] = useState([])
    useEffect(() => {
        getAllEmployees();
    }, [])
    const getAllEmployees = () => {
        EmployeeService.getEmployees().then((res) => {
            setEmployees(res.data);
        }).catch(error => {
            console.log(error);
        });
    }
    const deleteEmployeeByid = (id) => {
        EmployeeService.deleteEmployee(id).then((res) => {
            getAllEmployees();
        });
    }
    return (
        <div>
            <h2 className='text-center'>Employees List</h2>
            <div className='row'>
                <Link to="/add-employee" className="btn btn-primary mb-2">Add Employee</Link>
            </div>
            <div className='row'>
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Employee Id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            employees.map(
                                employee => 
                                    <tr key={employee.id}>
                                        <td>{employee.id}</td>
                                        <td>{employee.firstName}</td>
                                        <td>{employee.lastName}</td>
                                        <td>{employee.emailId}</td>
                                        <td>
                                            <Link className='btn btn-info' to={`/update-employee/${employee.id}`}>Update</Link>
                                            <button className='btn btn-info' onClick={() => deleteEmployeeByid(employee.id)}>Delete</button>
                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default ListEmployeeComponent;