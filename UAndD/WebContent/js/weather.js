/**
 *
 */

$(()=>
{
	// 현재 날짜 가져오기
	function convertTime()
	{
	    var now = new Date();
	    var month = now.getMonth() + 1; 
	    var date = now.getDate();
	    return month + '월' + date + '일';
	}
	var currentTime = convertTime();
	$('.nowTime').append(currentTime);
});


$.ajax
({
	// openweather 사용: 대전 날씨 가져오기
    url: 'https://api.openweathermap.org/data/2.5/weather?q=daejeon&appid=b3b41eae716e8329e1ff8d06e13e93d1&units=metric',
    dataType: 'json',
    type: 'GET',
    success: function(data) 
		{
        var $Temp = Math.floor(data.main.temp) + '°C';
        var $city = data.name;

    // 날씨 아이콘 변경
    	const changeWeatherIcon = (description) =>
			{
	            let iconClass = '';
	            let iconColor ='';

	            if (description == 'clear sky')
				{
	                iconClass = 'fas fa-sun';
	                iconColor = 'orange';
	            }
				else if (description == 'few clouds')
				{
	                iconClass = 'fas fa-cloud-sun';
	                iconColor = 'gray';
	            }
				else if (description.includes('clouds') || !(description == 'few clouds'))
				{
	                iconClass = 'fas fa-cloud';
	                iconColor = 'skyblue';
	            }
				else if (description.includes('rain'))
				{
	                iconClass = 'fas fa-cloud-rain';
	                iconColor = 'skyblue';
	            }
				else if (description == 'thunderstorm')
				{
	                iconClass = 'fas fa-bolt';
	                iconColor = 'gray';
	            }
				else if (description == 'snow')
				{
	                iconClass = 'fas fa-snowflake';
	                iconColor = 'gray';
	            }
				else if (description == 'mist')
				{
	                iconClass = 'fas fa-water';
	                iconColor = 'gray';
	            }
	            return { iconClass, iconColor };
        }

    // 날씨 아이콘 추가 및 변경
    const weatherDescription = data.weather[0].description;
    const { iconClass, iconColor } = changeWeatherIcon(weatherDescription);
    const iconHtml = '<i class="' + iconClass + '" style="color: ' + iconColor + ';"></i>';
    $('.weather_icon').html(iconHtml);
    $('.currTemp').html($Temp);
    $('.city').html($city);
	}
});
