fun main() {
    print(isMAC48Address("00-1B-63-84-45-E6"))
}

fun isMAC48Address(inputString: String): Boolean {
    if(inputString.length<3 || '-' !in inputString)
        return false
    var count=0
    var myIndex1=0
    for(i in 0 until inputString.length)
        if(i==inputString.length-1)
            count+=ismac(inputString.slice(myIndex1..i))
        else if(inputString[i]=='-'){
            count+=ismac(inputString.slice(myIndex1 until i))
            myIndex1=i+1}
        else
            continue

    var count1=0
    inputString.forEach{if(it=='-') count1++}
    if(count==12 && count1==5)
        return true
    else
        return false
}

fun ismac(St: String):Int{
    var count=0
    for(i in 0 until St.length){
        if(St[i].isDigit()){
            if(St[i].toString().toInt()>=0 && St[i].toString().toInt()<=9)
                count++}
        else if(St[i]>='A' && St[i]<='F')
            count++
        else
            count--}
    if(St.length>2)
        count=0
    return count
}