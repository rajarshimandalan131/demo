import React, { useEffect, useState } from 'react';
import {Link, useNavigate, useParams} from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';

const CreateEmployeeComponent = () => {
    const[firstName, setFirstName] = useState('');
    const[lastName, setLastName] = useState('');
    const[emailId, setEmailId] = useState('');
    const[titleValue, setTitleValue] = useState('');
    const navigate = useNavigate();
    const {id} = useParams();
    const showTitle = '';

    const saveOrUpdaateEmployee = (e) => {
        e.preventDefault();
        const employee = {firstName, lastName, emailId}
        console.log('inside saveOrUpdate', employee);
        if(id){
            EmployeeService.updateEmployee(id, employee).then((response) => {
                console.log('update response.data', response.data);
                navigate("/employees");
            }).catch(error => {
                console.log(error);
            });
        }else{
            EmployeeService.addEmployee(employee).then((response) => {
                console.log('add response.data', response.data);
                navigate("/employees");
            }).catch(error => {
                console.log(error);
            });
        }
    }
    const title = () => {
        console.log(firstName, lastName, emailId);
        if(id)
            return 'Update';
        else
            return 'Add';
    }
    useEffect(() => {
        EmployeeService.getEmployeeById(id).then((res) => {
            setFirstName(res.data.firstName);
            setLastName(res.data.lastName);
            setEmailId(res.data.emailId);
        })
    })
    
    return (
        <div>
            <br/><br/>
          <div className='container'>
            <div className='row'>
                <div className='card col-mod-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>{showTitle} Employee</h2>
                    <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                <label className='form-label'>First Name</label>
                                <input type = 'text' placeholder='enter first name' className='form-control' defaultValue = {firstName} onChange = {(e) => setFirstName(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Last Name</label>
                                <input type = 'text' placeholder='enter last name' className='form-control' defaultValue = {lastName} onChange = {(e) => setLastName(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Email Id</label>
                                <input type = 'text' placeholder='enter email id' className='form-control' defaultValue = {emailId} onChange = {(e) => setEmailId(e.target.value)}></input>
                            </div>
                            <button className='btn btn-success' onClick={(e)=>{saveOrUpdaateEmployee(e)}}>Save</button>
                            <Link to ="/employees" className='btn btn-danger'>Cancel</Link>
                        </form>
                    </div>
                </div>
            </div>
          </div>
        </div>
    )
}


export default CreateEmployeeComponent;