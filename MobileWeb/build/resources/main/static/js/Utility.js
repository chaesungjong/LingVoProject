/**
 * api 통신 공통 함수
 * @param {API 주소}  url 
 * @param {데이터}    data 
 * @param {성공 콜백} successCallback 
 * @param {실패 콜백} errorCallback 
 */
function ajaxRequest(url, data, successCallback, errorCallback) {

    $.ajax({
      url: url,
      method: "GET",
      data: data,
      dataType: "json",
      success: successCallback,
      error: errorCallback
    });

  }
/**
 * 현재 위치의 위도 경도를 확인하여 날씨 정보 가져오기
 */
function getLocation(successCallback) {
  if (navigator.geolocation) { 
    navigator.geolocation.getCurrentPosition(function(position) {
      weatherInformation(position.coords.latitude,position.coords.longitude,successCallback);
    }, function(error) {
      try{
        window.HyBridApp.getLocation();
      }
      catch(e){

      }
    }, {
      enableHighAccuracy: false,
      maximumAge: 0,
      timeout: Infinity
    });
  } else {
    alert('GPS를 지원하지 않습니다');
  }
}

/**
 * 위도 경도를 통하여 날씨 정보 가져오기 
 * @param   {위도}        latitude
 * @param   {경도}        longitude
 * @param   {성공 콜백}    successCallback 
 */
function weatherInformation(latitude, longitude, successCallback){

  var apiKey = "jJfUotrchvpyXABHlFPVuoHKuexVcER5";
  var locationUrl = `http://dataservice.accuweather.com/locations/v1/cities/geoposition/search?apikey=${apiKey}&q=${latitude},${longitude}&language=ko-kr&toplevel=true`;

  $.getJSON(locationUrl, function(locationResponse) {

    //지역 키, 지역 이름
    var locationKey = locationResponse.Key;
    var regionName = locationResponse.LocalizedName;

    var currentConditionsUrl = `http://dataservice.accuweather.com/currentconditions/v1/${locationKey}?apikey=${apiKey}&language=ko-kr&toplevel=true`;
    var forecastUrl = `http://dataservice.accuweather.com/forecasts/v1/daily/1day/${locationKey}?apikey=${apiKey}&language=ko-kr&toplevel=true&metric=true`;

    $.getJSON(currentConditionsUrl, function(currentConditionsResponse) {


      $.getJSON(forecastUrl, function(forecastResponse) {
        
        //오늘의 최고 온도, 최저 온도
        var today = forecastResponse.DailyForecasts[0];
        var date = new Object();
        date.regionName = regionName;
        date.today = forecastResponse.DailyForecasts[0];
        date.currentTemperature = currentConditionsResponse[0].Temperature.Metric.Value;
        date.todayHighTemperature = today.Temperature.Maximum.Value;
        date.todayLowTemperature = today.Temperature.Minimum.Value;
        date.todayIconPhrase = forecastResponse.DailyForecasts[0].Day.IconPhrase;
        date.MobileLink = forecastResponse.Headline.MobileLink;

        successCallback(date);

      });
    });
  });
}

/**
 * QR 코드 스캔
 */
function openQRCode(url){
  try{
    window.HyBridApp.callQRCode(url);
  }
  catch(e){
    resultQRCode('QR_0000001',url);
  }
}

/**
 * QR 코드 결과
 * @param {*} qrCode 
 * @param {*} url 
 */
function resultQRCode(qrCode,url){
  location.href = url+"?qrCode="+qrCode;
}


/**
 * 사진 추가 콜백 함수
 */
var addPictureCallback = null;
/**
 * 사진 찍기 
 * @param {*} callback 콜백 함수
 */
function callCamera(callback){
  try{
    addPictureCallback = callback;
    window.HyBridApp.callCamera();
  }
  catch(e){

  }
}

/**
 * 갤러리에서 사진 가져오기
 * @param {*} callback 
 */
function callGallery(callback){
  try{
    addPictureCallback = callback;
    window.HyBridApp.callGallery();
  }catch(e){
    
  }
}
