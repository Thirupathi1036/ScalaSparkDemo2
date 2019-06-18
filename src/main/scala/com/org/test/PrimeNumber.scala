package com.org.test

object PrimeNumber extends App {

  var num=15
  var prime=true
  for(i <- 2 to num/2){
    if(num%i==0) {
      prime=false
    }
  }
  if(prime) println("Prime Number")
  else println("Not Prime")
}
