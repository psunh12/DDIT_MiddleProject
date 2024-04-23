/**
 * 
 */
// 카카오맵 api에 관련된 script들




    
 
	   mypath='<%=request.getContextPath()%>';   
   /*
      $(()=>{
           if(data!=null){
             	displayPlaces(data);
             	displayPagination(pagination);
           }else{
        	   alert("검색 결과 없음");
        	   return null;
           }
})*/
       function placesSearchCB(data, status, pagination) {
    	    if (status === kakao.maps.services.Status.OK) {
    	       
    	    	displayPlaces(data);
    	        displayPagination(pagination);
    	    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
    	        alert('검색 결과가 존재하지 않습니다.');
    	    } else if (status === kakao.maps.services.Status.ERROR) {
    	        alert('검색 결과 중 오류가 발생했습니다.');
    	    }
    	}

    
     // 장소 목록을 표시하는 함수
        function displayPlaces(places) {
            var bounds = new kakao.maps.LatLngBounds();
            var listEl = document.getElementById('placesList');
            removeAllChildNods(listEl);

            removeMarker();

            for (var i = 0; i < places.length; i++) {
                var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
                    marker = addMarker(placePosition,i,places),
                    itemEl = getListItem(i, places[i]);

                bounds.extend(placePosition);

                (function (marker, title, address, phone) {
                    kakao.maps.event.addListener(marker, 'mouseover', function () {
                        displayInfowindow(marker, title, address, phone);
                    });

                    kakao.maps.event.addListener(marker, 'mouseout', function () {
                        infowindow.close();
                    });

                    itemEl.onmouseover = function () {
                        displayInfowindow(marker, title, address, phone);
                    };

                    itemEl.onmouseout = function () {
                        infowindow.close();
                    };
                })(marker, places[i].place_name, places[i].road_address_name || places[i].address_name, places[i].phone);

                listEl.appendChild(itemEl);
            }

            map.setBounds(bounds);
        }

        // 장소 목록의 각 항목을 생성하는 함수
        function getListItem(index, places) {
            var el = document.createElement('li'),
                itemStr = '<span class="markerbg marker_' + (index + 1) + '"></span>' +
                '<div class="info">' +
                '   <h5>' + places.place_name + '</h5>';

            if (places.road_address_name) {
                itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' + places.address_name + '</span>';
            } else {
                itemStr += '    <span>' + places.address_name + '</span>';
            }

            itemStr += '  <span class="tel">' + places.phone + '</span>' +
                '</div>';

            el.innerHTML = itemStr;
            el.className = 'item';
            
            // jQuery를 이용하여 클릭 이벤트 추가
            $(el).on('click', function() {
                // 클릭한 장소에 대한 정보 출력
                alert('장소 이름:'+ places.place_name);
                console.log('도로명 주소:', places.road_address_name);
                console.log('지번 주소:', places.address_name);
                console.log('전화번호:', places.phone);

                // 원하는 동작을 추가하여 클릭한 리스트 아이템에 대해 특정 작업을 수행할 수 있습니다.
                // 예를 들어, 클릭한 장소를 지도에서 강조 표시하는 등의 작업을 추가할 수 있습니다.
            });

            return el;
        }

        // 마커를 지도에 추가하는 함수
        function addMarker(position, idx,places) {
            var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png',
                imageSize = new kakao.maps.Size(36, 37),
                imgOptions = {
                    spriteSize: new kakao.maps.Size(36, 691),
                    spriteOrigin: new kakao.maps.Point(0, (idx * 46) + 10),
                    offset: new kakao.maps.Point(13, 37)
                },
                markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
                marker = new kakao.maps.Marker({
                    position: position,
                    image: markerImage
                });
           
            marker.setMap(map);
            markers.push(marker);
            
            kakao.maps.event.addListener(marker, 'click', function() {
                // 클릭된 마커의 인덱스를 가져옵니다.
                var markerIndex = markers.indexOf(marker);

                // 해당 마커에 대응하는 장소 정보를 가져옵니다.
                var clickedPlace = data[markerIndex]; // data 배열에서 마커와 인덱스가 일치하는 장소 정보 가져오기

               alert(clickedPlace.address_name); // 클릭된 마커에 연관된 장소 정보 확인
            });

            return marker;
        }

        // 모든 마커를 지도에서 제거하는 함수
        function removeMarker() {
            for (var i = 0; i < markers.length; i++) {
                markers[i].setMap(null);
            }
            markers = [];
        }

        // 페이지네이션을 표시하는 함수
        function displayPagination(pagination) {
            var paginationEl = document.getElementById('pagination'),
                fragment = document.createDocumentFragment(),
                i;
/* 
            // totalCount와 itemsPerPage가 있다고 가정
            var totalCount = 100; // API로 받아온 데이터의 총 개수
            var itemsPerPage = 10; // 페이지당 보여줄 아이템의 개수
            var totalPages = Math.ceil(totalCount / itemsPerPage); // 총 페이지 수 */
            
            while (paginationEl.hasChildNodes()) {
                paginationEl.removeChild(paginationEl.lastChild);
            }

            for (i = 1; i <= pagination.last; i++) {
                var el = document.createElement('a');
                el.href = "#";
                el.innerHTML = i;

                if (i === pagination.current) {
                    el.className = 'on';
                } else {
                    el.onclick = (function(i) {
                        return function() {
                            pagination.gotoPage(i);
                        }
                    })(i);
                }

                fragment.appendChild(el);
            }
            paginationEl.appendChild(fragment);
        }

     // 인포윈도우를 표시하는 함수
        function displayInfowindow(marker, title, address, phone) {
            var content = '<div style="padding:20px;z-index:1;">' +
                '<h4>' + title + '</h4>' +
                '<p>주소: ' + address + '</p>' +
                '<p>전화번호: ' + phone + '</p>' +
                '</div>';
            infowindow.setContent(content);
            infowindow.open(map, marker);
        }

        // 엘리먼트의 자식 노드를 모두 제거하는 함수
        function removeAllChildNods(el) {
            while (el.hasChildNodes()) {
                el.removeChild(el.lastChild);
            }
        }



	
function displayTour(){	
	  resetMap();
	$.ajax({
		url:`${mypath}/tour/tourList.do`,
		type:'get',
 		success: function(res){   // ajax로 가져온 json데이터 res를 for문으로 돌린다			    		   
			res.forEach(function(item) { // tour_addr값을 주소로하여 마커를 찍는다
			geocoder.addressSearch(item.tour_addr, function(result, status) {
 			if (status === kakao.maps.services.Status.OK) {
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
 			var marker = new kakao.maps.Marker({
			map: map,
			position: coords
			});
			markers.push(marker);
			var  infowindow = new kakao.maps.InfoWindow({
				content: `<div id="infowindow" > 
				${item.tour_name}<p>
							</div>`
				});
				kakao.maps.event.addListener(marker, 'mouseover', function() {
				infowindow.open(map, marker);
				 });

				kakao.maps.event.addListener(marker, 'mouseout', function() {
				infowindow.close();
				}); 
				
				kakao.maps.event.addListener(marker, 'click', function() {
				detailTour(item);			
				}); 
					// 리스트에 아이템 추가
			var listItem = $('<li class="lists"></li>')
					.html(`	       <table>
        									<tr>
        										<td rowspan="2">
        											<div class="tour_img_div">
        												<img src="${path}/images/tour/${item.tour_img}"
        													style="width: 100px; height: 100px;
        														border-radius: 70%; margin-right:10px;">
        											</div>
        										</td>
        										<td class ="cont">${item.tour_name}</td>
        									</tr>
        									<tr>
        										<td class ="cont">${item.tour_addr}</td>
        									</tr>
        								<div class="adminPlace" style="display:none" name="${item.tour_no}">
				<input type="button" class="cateBtn" name="tourDelete" value="삭제">
                <input type="button" class="cateBtn" name="tourUpdate" value="수정"></div>
        								</table> <hr>`);
				// 클릭 이벤트 추가
				listItem.on('click', function() {
					infowindows.forEach(function(window) {
					window.close();
					});
					infowindow.open(map, marker);
					infowindows.push(infowindow);
					detailTour(item);
    		        map.panTo(coords);                     
				setTimeout(function() {
				infowindow.close();
				 }, 3500);
					}); 

				// 리스트를 출력할 요소에 추가
				$('#placesList').append(listItem);
					 }
				});
			});
               
				},
		error: function(xhr){
			alert(xhr.status);
				},
		dataType: 'json'			
		})


}
  $(()=>{
	$(document).on('click','.cateBtn',function(){
		cate=$(this).attr('name');
		gthis=$(this);
	  
		if(cate=="daeAll"){
			  clearMarkers();
             $('#placesList').empty(); 
			displayTour();		
		}
	    if(cate=="daeYou"){
		      clearMarkers();
             $('#placesList').empty(); 
		    displayOneTour("유성구");
	    }
	    if(cate=="daeSeo"){
		      clearMarkers();
             $('#placesList').empty(); 
		    displayOneTour("서구");
	    }
	    if(cate=="daeJung"){
		    clearMarkers();
             $('#placesList').empty(); 
		    displayOneTour("중구");
	    }
	    if(cate=="daeDong"){
		    clearMarkers();
             $('#placesList').empty(); 
		    displayOneTour("동구");
	    }
	    if(cate=="daeDae"){
		     clearMarkers();
             $('#placesList').empty(); 
		    displayOneTour("대덕구");
	    }
       if(cate=="mapinsert"){
		  $('#wModal').modal('show');
            
	    }
        if(cate=="insertsend"){	
        var formData = $('#wform').serializeArray(); // 폼 데이터를 배열로 가져옴
        var fdata = {};

         $(formData).each(function(i, v){
         fdata[v.name] = v.value; // 각각의 폼 데이터를 JSON 객체에 추가
           });

         if(jpgname !=""){
         fdata['tour_img'] = jpgname;
         insertTour(fdata);
         window.location.reload();
        // displayOneTour();
         
	     }          
	     }                
         if(cate=="uploadimg"){	
	       insertFile();      
         }
          if(cate=="uuploadimg"){	
	       insertFileforUpdate();      
         }
         if(cate=="tourDelete"){
	      tno= $(this).parent().attr("name");
         if(confirm('정말 삭제하시겠습니까?'))
          tourDelete(tno);
          window.location.reload();
            
         } 



			 if(cate=="updatesend"){				
		    formData = $('#uform').serializeArray(); // 폼 데이터를 배열로 가져옴
            udata = {};

           $(formData).each(function(i, v){
           udata[v.name] = v.value; // 각각의 폼 데이터를 JSON 객체에 추가
           });
             if(jpgname !=""){
             udata['tour_img'] = jpgname; 
             console.log(udata);
             UpdateTour(udata);
               window.location.reload(); 
		      }	
          }    
            if(cate=="tourList"){ //주요관광지 버튼 누르면
		     clearMarkers();
             $('#placesList').empty(); 
		     displayOneTour();
             } 
            if(cate=="resList"){ 	    
             location.href = `${mypath}/view/restaurant/resboard/resMain.jsp`;   
             } 
            if(cate=="hotelList"){ 
	        
		     location.href = `${mypath}/hotel/hotelboard/hotelMain.jsp`;
             } 
             if(cate =="tourUpdate"){ 
	            	 //수정 모달 창을 띄운다.
			 //본문의 내용을 가져온다.
	          $('#result2').css("display","none"); 
			  vparents= $(this).parents('.lists');
	        
			  vplacename= $(vparents).find('.cont:eq(0)').text().trim();
			  vaddr=$(vparents).find('.cont:eq(1)').text().trim();
			  
	          vno = $(vparents).find('.adminPlace').attr('name');
			   
			   /*alert(vtype);
			   alert(vplacename);*/
			  //모달창에 출력 
			  
			 
			 $('#uform #utour_name').val(vplacename);
			 $('#uform #utour_no').val(vno);
			
			 $('#uform #utour_addr').val(vaddr);
			
			 
			 //수정모달창에 본문의 내용을 출력한다. -제목, 이름, 이메일, 내용,비밀번호
			 $("#uModal").modal('show');   

          }
 
})// cateBtn 끝
 
 
})// $(()=> {}) 끝 
  $(document).on('click','#searchBtn' ,function(){
        sword=$('#searchbox').val().trim();               
             clearMarkers();
             $('#placesList').empty(); 
             searchByTourName(sword);
		   
})

function displayOneTour(dong){	
	  daeDong=dong; 
      resetMap();
	$.ajax({
		url:`${mypath}/tour/tourListOne.do`,
		type:'get',
		data:{"dong":daeDong},
 		success: function(res){   // ajax로 가져온 json데이터 res를 for문으로 돌린다			    		   
			res.forEach(function(item) { // tour_addr값을 주소로하여 마커를 찍는다
			geocoder.addressSearch(item.tour_addr, function(result, status) {
 			if (status === kakao.maps.services.Status.OK) {
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
 			var marker = new kakao.maps.Marker({
			map: map,
			position: coords
			});
			markers.push(marker);
			var  infowindow = new kakao.maps.InfoWindow({
				content: `<div id="infowindow" > 
				${item.tour_name}<p>
							</div>`
				});
				kakao.maps.event.addListener(marker, 'mouseover', function() {
				infowindow.open(map, marker);
				 });

				kakao.maps.event.addListener(marker, 'mouseout', function() {
				infowindow.close();
				}); 
				
			    kakao.maps.event.addListener(marker, 'click', function() {
				detailTour(item);				
				}); 
					// 리스트에 아이템 추가
			var listItem = $('<li class="lists"></li>')
				.html(`	       <table>
        									<tr>
        										<td rowspan="2">
        											<div class="tour_img_div">
        												<img src="${path}/images/tour/${item.tour_img}"
        													style="width: 100px; height: 100px;
        														border-radius: 70%; margin-right:10px;">
        											</div>
        										</td>
        										<td>${item.tour_name}</td>
        									</tr>
        									<tr>
        										<td>${item.tour_addr}</td>
        									</tr>
        								<div class="adminPlace" style="display:none" name="${item.tour_no}">
				<input type="button" class="cateBtn" name="tourDelete" value="삭제">
                <input type="button" class="cateBtn tourUpdate" name="tourUpdate" value="수정"></div>
        								</table> <hr>`);
				// 클릭 이벤트 추가
				listItem.on('click', function() {
					infowindows.forEach(function(window) {
					window.close();
					});
					infowindow.open(map, marker);
					infowindows.push(infowindow);
					detailTour(item);
    		        map.panTo(coords);                    
				setTimeout(function() {
				infowindow.close();
				 }, 3500);
					}); 

				// 리스트를 출력할 요소에 추가
				$('#placesList').append(listItem);
					 }
				});
			});
               
				},
		error: function(xhr){
			alert(xhr.status);
				},
		dataType: 'json'			
		})


}

function searchByTourName(dong){	
	  daeDong=dong; 
      resetMap();
	$.ajax({
		url:`${mypath}/tour/tourListName.do`,
		type:'get',
		data:{"dong":daeDong},
 		success: function(res){   // ajax로 가져온 json데이터 res를 for문으로 돌린다			    		   
			res.forEach(function(item) { // tour_addr값을 주소로하여 마커를 찍는다
			geocoder.addressSearch(item.tour_addr, function(result, status) {
 			if (status === kakao.maps.services.Status.OK) {
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
 			var marker = new kakao.maps.Marker({
			map: map,
			position: coords
			});
			markers.push(marker);
			var  infowindow = new kakao.maps.InfoWindow({
				content: `<div id="infowindow" > 
				${item.tour_name}<p>
							</div>`
				});
				kakao.maps.event.addListener(marker, 'mouseover', function() {
				infowindow.open(map, marker);
				 });

				kakao.maps.event.addListener(marker, 'mouseout', function() {
				infowindow.close();
				}); 
				
			    kakao.maps.event.addListener(marker, 'click', function() {
				detailTour(item);
				}); 
					// 리스트에 아이템 추가
			var listItem = $('<li class="lists"></li>')
				.html(`	       <table>
        									<tr>
        										<td rowspan="2">
        											<div class="tour_img_div">
        												<img src="${path}/images/tour/${item.tour_img}"
        													style="width: 100px; height: 100px;
        														border-radius: 70%; margin-right:10px;">
        											</div>
        										</td>
        										<td>${item.tour_name}</td>
        									</tr>
        									<tr>
        										<td>${item.tour_addr}</td>
        									</tr>
        								<div class="adminPlace" style="display:none" name="${item.tour_no}">
				<input type="button" class="cateBtn" name="tourDelete" value="삭제">
                <input type="button" class="cateBtn" name="tourUpdate" value="수정"></div>
        								</table> <hr>`);
				// 클릭 이벤트 추가
				listItem.on('click', function() {
					infowindows.forEach(function(window) {
					window.close();
					});
					infowindow.open(map, marker);
					infowindows.push(infowindow);
					detailTour(item);
    		        map.panTo(coords);                     
				setTimeout(function() {
				infowindow.close();
				 }, 3500);
					}); 

				// 리스트를 출력할 요소에 추가
				$('#placesList').append(listItem);
					 }
				});
			});
               
				},
		error: function(xhr){
			alert(xhr.status);
				},
		dataType: 'json'			
		})


}
function resetMap(){
	  map.setCenter(new kakao.maps.LatLng(36.3519957, 127.39131469)); 
      map.setLevel(6);
}

function clearMarkers() {
    for (let i = 0; i < markers.length; i++) {
        markers[i].setMap(null); // 이전 마커를 지도에서 제거
    }
    markers = []; // markers 배열을 비워서 마커를 초기화
}
 $(document).on("click","#tashuBtn",function(){  // 타슈api를 불러와서 타슈를 나오게하는 메서드
	  clearMarkers();
      $('#placesList').empty(); 
    
      map.setCenter(new kakao.maps.LatLng(36.322967,127.412130)); 
      map.setLevel(3);
	$.ajax({
		url:`${mypath}/tashu/tashuTest.do`,
		type:'get',
 		success: function(res){   // ajax로 가져온 json데이터 res를 for문으로 돌린다			    		   
			res.results.forEach(function(item) { // tour_addr값을 주소로하여 마커를 찍는다
			geocoder.addressSearch(item.address, function(result, status) {
 			if (status === kakao.maps.services.Status.OK) {
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
 			var marker = new kakao.maps.Marker({
			map: map,
			position: coords
			});
			markers.push(marker);
			var  infowindow = new kakao.maps.InfoWindow({ //content의 값 변경
				content: `<div id="infowindow" > 
				타슈 위치 : ${item.name}<p>         
							</div>`
				});
				kakao.maps.event.addListener(marker, 'mouseover', function() {
				infowindow.open(map, marker);
				 });

				kakao.maps.event.addListener(marker, 'mouseout', function() {
				infowindow.close();
				}); 
				

					// 리스트에 아이템 추가 여기도 변경
			var listItem = $('<li ></li>')
				.html(`<p>장소 이름: ${item.name}</p><p>주소: ${item.address}</p><p>타입: ${item.id}</p><p><hr>`);

				// 클릭 이벤트 추가
				listItem.on('click', function() {
					infowindows.forEach(function(window) {
					window.close();
					});
					infowindow.open(map, marker);
					infowindows.push(infowindow);
			
    		        map.panTo(coords);                    
				setTimeout(function() {
				infowindow.close();
				 }, 3500);
					}); 

				// 리스트를 출력할 요소에 추가
				$('#placesList').append(listItem);
					 }
				});
			});
               
				},
		error: function(xhr){
			alert(xhr.status);
				},
		dataType: 'json'			
		})

})



function insertFile() {
    var formData = new FormData();
    var fileInput = document.getElementById('tour_img'); 
        jpgname= fileInput.files[0].name;
    formData.append('file', fileInput.files[0]); 
    var forms = new FormData($('#wform')[0]);

    $.ajax({
        url: `${mypath}/fileUpload.do`,
        type: 'POST',
        data: formData,
        processData: false,
        contentType: false,
        dataType: 'json',
        success: function(res) {
            alert(res);
        },
        error: function(xhr) {
           
        }
    });
}
function insertTour(fdata) {
	  $.ajax({
        url: `${mypath}/tour/writeTour.do`,
        type: 'POST',
        data: fdata,
        dataType: 'json',
        success: function(res) {
            alert(res.flag);
        },
        error: function(xhr) {
            alert("실패 "+xhr.status);
        }
    });
}
function tourDelete(num){
	 $.ajax({
        url: `${mypath}/tour/deleteTour.do`,
        type: 'get',
        data: {"num":num},
        dataType: 'json',
        success: function(res) {
            alert(res.flag);
        },
        error: function(xhr) {
            alert("실패 "+xhr.status);
        }
    });
	
}
function insertFileforUpdate() {
    var formData = new FormData();
    var fileInput = document.getElementById('utour_img'); 
        jpgname= fileInput.files[0].name;
    formData.append('file', fileInput.files[0]); 
    var forms = new FormData($('#wform')[0]);

    $.ajax({
        url: `${mypath}/fileUpload.do`,
        type: 'POST',
        data: formData,
        processData: false,
        contentType: false,
        dataType: 'json',
        success: function(res) {
            alert(res);
        },
        error: function(xhr) {
           
        }
    });
}
UpdateTour =function(udata){
	$.ajax({
		url : `${mypath}/tour/tourUpdate.do`,
		type : 'post',
		data : udata,// writer ,subject ,mail,password, content
		success :function(res){
		
			alert(res.flag);
		    if(res.flag =="성공"){       
             
           
		}else{
			alert("전부 입력해 주세요!!");
		}
		
		},
		error : function(xhr){
		   alert(xhr.status);	
		},
		dataType: 'json'
	})
		
}


 function detailTour(item){   // 마커를 클릭하면 나타나는 모달(offcanvas)창
             		
		 code = `
	<div class="offcanvas offcanvas-end" id="demo">
		<div class="offcanvas-header">
			<h1 class="offcanvas-title" style="text-align:center;" >${item.tour_name}</h1>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas"></button>
			</div>
		<div class="offcanvas-body">
			<img src='${mypath}/images/tour/${item.tour_img}' style="width :350px; height :200px;">
			<br><br>
			<p>명소 타입 : ${item.tour_tp_nm}</p>
			<p>주소 : ${item.tour_addr}</p>
			<p>전화번호 : ${item.tour_tel}</p>
					
			<a href='${item.tour_url}'>${item.tour_url}</a>
					
			</div>
	</div>`;
                          
		$('#result2').html(code);

		var offcanvasElement = document.getElementById('demo');
		var offcanvas = new bootstrap.Offcanvas(offcanvasElement);
		offcanvas.show(); 
                		
  }

 