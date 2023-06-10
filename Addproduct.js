import axios from 'axios';
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

export default function AddDetails() {
  let navigate = useNavigate();

  const [product, setproduct] = useState({
  
    ccode: "",
    cname: "",
    cbrand: "",
    crate: "",
    cused: ""
  });

  const onInputChange = (e) => {
    setproduct({ ...product, [e.target.name]: e.target.value });
  };

  const {  cname,
    cbrand,
    crate,
    cused } = product;

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("localhost:8080/Components",product);
    navigate('/main');
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow ">
          <h2 className="text-center m-4">Add Details</h2>
          <form onSubmit={(e) => onSubmit(e)}>
          
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Product Name
              </label>
              <input
                type="text"
                className="form-control border-dark shadow"
                placeholder="Enter Product Name"
                name="cname"
                value={cname}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
              Product Brand
              </label>
              <input
                type="text"
                className="form-control border-dark shadow"
                placeholder="Enter Product Brand"
                name="cbrnd"
                value={cbrand}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Product Rate
              </label>
              <input
                type="text"
                className="form-control border-dark shadow"
                placeholder="Enter Rate"
                name="crate"
                value={crate}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
               Product Used
              </label>
              <input
                type="text"
                className="form-control border-dark shadow"
                placeholder="Enter Product Used"
                name="cused"
                value={cused}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            
            
            <button type="submit" className="btn btn-outline-success my-2">
              Add Details
            </button>
            <Link className="btn btn-outline-danger my-2 mx-2" to={"/main"}>
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}