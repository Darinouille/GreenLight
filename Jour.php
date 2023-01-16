
<?php

include("connexion.php");
try {
    $bd = new PDO ( "mysql:host = $server; dbname=$base", "$user", "$password"); 
    $bd->exec("SET NAMES utf8");
    //echo("Connexion à la base de donnée réussie, bien joué");
}
catch (Exception $e){
    print_r($e -> getMessage());
    die("Erreur de connexion à la base ");
}

$jour0 = $bd ->query("SELECT Jour.jour,Jour.idJour,Jour.`#dvalue`,Jour.generationFichier,Message.message FROM Jour  LEFT JOIN Message ON Jour.`#dvalue`=Message.dValue  WHERE Jour.idJour=0" );
$monjour0 = ($jour0->fetch(PDO::FETCH_ASSOC));

$jour1 = $bd ->query("SELECT Jour.jour,Jour.idJour,Jour.`#dvalue`,Jour.generationFichier,Message.message FROM Jour  LEFT JOIN Message ON Jour.`#dvalue`=Message.dValue  WHERE Jour.idJour=1" );
$monjour1 = ($jour1->fetch(PDO::FETCH_ASSOC));

$jour2 = $bd ->query("SELECT Jour.jour,Jour.idJour,Jour.`#dvalue`,Jour.generationFichier,Message.message FROM Jour  LEFT JOIN Message ON Jour.`#dvalue`=Message.dValue  WHERE Jour.idJour=2" );
$monjour2 = ($jour2->fetch(PDO::FETCH_ASSOC));

$jour3 = $bd ->query("SELECT Jour.jour,Jour.idJour,Jour.`#dvalue`,Jour.generationFichier,Message.message FROM Jour  LEFT JOIN Message ON Jour.`#dvalue`=Message.dValue  WHERE Jour.idJour=3" );
$monjour3 = ($jour3->fetch(PDO::FETCH_ASSOC));

$j0 = array(
    "jour: " => $monjour0['jour'],
    "dvalue: " => $monjour0['#dvalue'],
    "generation fichier: " => $monjour0['generationFichier'],
    "message: " => $monjour0['message'],
);

$j1 = array(
    "jour: " => $monjour1['jour'],
    "dvalue: " => $monjour1['#dvalue'],
    "generation fichier: " => $monjour1['generationFichier'],
    "message: " => $monjour1['message'],
);

$j2 = array(
    "jour: " => $monjour2['jour'],
    "dvalue: " => $monjour0['#dvalue'],
    "generation fichier: " => $monjour2['generationFichier'],
    "message: " => $monjour2['message'],
);

$j3 = array(
    "jour: " => $monjour3['jour'],
    "dvalue: " => $monjour3['#dvalue'],
    "generation fichier: " => $monjour3['generationFichier'],
    "message: " => $monjour3['message'],
);




$tableau = array(
    "Jour0: " => $j0,
    "Jour1: " => $j1,
    "Jour2: " => $j2,
    "Jour3: " => $j3,

);

//print_r($j0);


echo json_encode($tableau);


?>



