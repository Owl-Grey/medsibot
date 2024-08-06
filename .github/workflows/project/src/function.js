


function Getcity(city){
return $http.get('https://kong-in.medsi.pro/clinics/clinics/v1/cities/?name=${city}page=1&size=1', {
    query:{
        city: city
    },
    headers: {
        'Authorization': 'Basic Y2hhdGJvdGdhdGV3YXk6SzhDVlg0L3hCa1R5I0p7dVI/YixjTg=='
        
    }
    
});
    
}