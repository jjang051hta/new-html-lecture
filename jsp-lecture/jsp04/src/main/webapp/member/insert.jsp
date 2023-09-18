<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <script src="../js/bootstrap.bundle.min.js"></script>
    <script src="../js/jquery-3.7.1.min.js"></script>
  </head>
  <body>
    <div class="container">
      <form action="insert-member-process.jsp" method="post" class="" name="member">
        <div class="row d-flex justify-content-center mt-5">
          <div class="col-6">
            <div class="mb-3">
              <label for="userID" class="form-label">ID</label>
              <input type="text" class="form-control" id="userID" placeholder="user id" name="userID" />
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userPW" class="form-label">password</label>
              <input type="password" class="form-control" id="userPW" placeholder="user password" name="userPW" />
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userPW02" class="form-label">password Confirm</label>
              <input type="password" class="form-control" id="userPW02" placeholder="user password" />
              <div class="invalid-feedback">글자 써보기</div>
            </div>
          </div>
        </div>

        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userName" class="form-label">Name</label>
              <input type="text" class="form-control" id="userName" placeholder="user name" name="userName" />
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="postCode" class="form-label">ZipCode</label>
              <input type="text" class="form-control" id="postCode" placeholder="post code" name="postCode" />
              <div>
                <button type="submit" class="btn btn-primary mt-3">우편번호 확인</button>
              </div>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="address" class="form-label">Address</label>
              <input type="text" class="form-control" id="address" name="address" placeholder="address" />
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="detailAddress" class="form-label">Detail Address</label>
              <input type="text" class="form-control" id="detailAddress" placeholder="detail address" name="detailAddress" />
            </div>
          </div>
        </div>
        <div class="mt-5 mb-5 d-flex justify-content-center">
          <div class="col-6">
            <button type="submit" class="btn btn-primary" id="btnSubmit">회원가입</button>
            <button type="reset" class="btn btn-secondary">취소</button>
          </div>
        </div>
      </form>
    </div>

    <script>
      $("#btnSubmit").on("click", function (e) {
        if ($("#userID").val().trim() === "") {
          alert("id는 필수입력 사항입니다.");
          $("#userID").val("");
          $("#userID").focus();
          return false;
        } else if ($("#userPW").val().trim() === "") {
          alert("password는 필수입력 사항입니다.");
          $("#userPW").val("");
          $("#userPW").focus();
          return false;
        } else if ($("#userPW02").val().trim() === "") {
          alert("password 확인");
          $("#userPW02").val("");
          $("#userPW02").focus();
          return false;
        }
      });
      $("#userPW02").on("keyup", function () {
        if ($("#userPW").val() !== $("#userPW02").val()) {
          $(".invalid-feedback").show();
          $(".invalid-feedback").text("password가 맞지 않습니다.");
        } else {
          $(".invalid-feedback").hide();
          $(".invalid-feedback").text("");
        }
      });
      //   const btnSubmit = document.querySelector("#btnSubmit");
      //   btnSubmit.addEventListener("click", function (e) {
      //     if (member.userID.value.trim() === "") {
      //       e.preventDefault();
      //       alert("id는 필수입력 사항입니다.");
      //       member.userID.value = "";
      //       member.userID.focus();
      //       return false;
      //     }
      //   });
    </script>
  </body>
</html>
