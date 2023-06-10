import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams, useNavigate } from "react-router-dom";

export default function EditDetails() {
  let navigate = useNavigate();
  const { dserialno } = useParams();
  console.log(dserialno);
  const [Product, setproduct] = useState({
    ccode: "",
    cname: "",
    cbrnd: "",
    crate: "",
    cused: "",
   
  });

  useEffect(() => {
    loadproduct();
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const loadproduct = async () => {
    const result = await axios.get(`localhost:8080/sortdes/cname`);
    setproduct(result.data);
  };

  const onInputChange = (e) => {
    setproduct({ ...Product, [e.target.name]: e.target.value });
  };

  const {
    cname,
    cbrnd,
    crate,
    cused
   
  } = Product;

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`localhost:8080/updatestock`, Product);
    navigate("/main");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Edit Details</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
               Product Name
              </label>
              <input
                type="text"
                className="form-control border-dark shadow"
                placeholder="Enter  Product Name"
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
                value={cbrnd}
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
                placeholder="Enter Product Used"
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
            
            <button type="submit" className="btn btn-primary my-2">
              Update Details
            </button>
            <Link className="btn btn-primary my-2 mx-2" to={"/main"}>
              Back to Home
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}