const result = fetch(
  "https://apis.data.go.kr/1352000/ODMS_COVID_04/callCovid04Api?serviceKey=Wnus4QpirWGI56CfvzMWDIDHMRL%2FmEF%2FqTl9gwVNbRggLYTGPFIdwBy0L51B%2B27d5QRbLanNmIAxPwNvl7dKPA%3D%3D&pageNo=1&numOfRows=500&apiType=JSON&std_day=2023-08-07"
)
  .then(function (response) {
    //console.log(response);
    return response.json();
  })
  .then(function (result) {
    console.log(result.items[0].incDec);
    result.items.forEach(function (item) {
      console.log(item.gubun + ":" + item.incDec);
    });
  });
