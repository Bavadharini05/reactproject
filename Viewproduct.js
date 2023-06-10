import React from 'react';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useParams } from 'react-router-dom';

export default function ViewDetails() {
// const {busid}
  const [product,setproduct] = useState({
    ccode: '',
    cname: '',
    cbrnd: '',
    crate: '',
    cused: ''
    
  });
  
  const {ccode} = useParams();
  console.log(ccode);


  useEffect(() => {
    loadproduct();
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const loadproduct = async () => {
    const result = await axios.get(`localhost:8080/sortdes/cname`);
    setproduct(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">STOCK DETAILS</h2>

          <div className="card">
            <div className="card-header">
              Detail of Stock:
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>ccode </b>
                  {product.ccode}
                </li>
                <li className="list-group-item">
                  <b>cname </b>
                  {product.cname}
                </li>
                <li className="list-group-item">
                  <b>cbrnd </b>
                  {product.cbrnd}
                </li>
                <li className="list-group-item">
                  <b>crate </b>
                  {product.crate}
                </li>
                <li className="list-group-item ">
                  <b>cused: </b>
                  {product.cused}
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-primary my-2" to={"/login"}>
            LOGOUT
          </Link>
        </div>
      </div>
    </div>
  );
}