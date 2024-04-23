<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 4</title>
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style>
      p { margin:20px 0px; }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-6">
          <p>Card</p>
          <div class="card">
            <div class="card-header">
              My Card
            </div>
            <img src="images/card-image.png" alt="" />
            <div class="card-body">
              <h5 class="card-title">Lorem</h5>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas sed sem ut malesuada.</p>
              <a href="#" class="btn btn-primary">More</a>
            </div>
          </div>
        </div>
        <div class="col-6">
          <p>Card</p>
          <div class="card">
            <div class="card-header">
              My Card
            </div>
            <img src="images/card-image.png" alt="" />
            <div class="card-body">
              <h5 class="card-title">Lorem</h5>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas sed sem ut malesuada.</p>
              <a href="#" class="btn btn-primary">More</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  
  </body>
</html>