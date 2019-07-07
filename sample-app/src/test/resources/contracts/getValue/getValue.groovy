package contracts.getValue;

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  description "should return value"
  priority 1
  request {
   method 'GET'
   urlPath('/currentvalue') 
   
    headers{ header('''Accept''', 'application/json') }
   }
  response {
    headers{ contentType("application/json;charset=UTF-8") }
   status 200

   bodyMatchers {
    jsonPath('$.value', byType())
   }

   body('''
    {
     "value": 401
    }
    ''')

   }
  }