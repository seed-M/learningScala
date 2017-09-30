
val firstArg = if(args.length>0) args(0) else ""

 val str =
   firstArg match{
     case "java" => "ok"
     case "python"=>"good"
     case "vb"=>"bad"
     case "c++"=>"even better"
     case _ =>"what?"
 }
 println(str)
