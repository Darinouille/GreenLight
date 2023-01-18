<?php
include("connexion.php");

// Les données du jour 0
$jour0 = $bd ->query("SELECT Jour.jour,Jour.idJour,Jour.`#dvalue`,Jour.generationFichier,Message.message FROM Jour  LEFT JOIN Message ON Jour.`#dvalue`=Message.dValue  WHERE Jour.idJour=0" );
$monjour0 = ($jour0->fetch(PDO::FETCH_ASSOC));

$j0 = array(
    "jour" => $monjour0['jour'],
    "dvalue" => $monjour0['#dvalue'],
    "generation fichier" => $monjour0['generationFichier'],
    "message" => $monjour0['message'],
);


// Les données du jour 1
$jour1 = $bd ->query("SELECT Jour.jour,Jour.idJour,Jour.`#dvalue`,Jour.generationFichier,Message.message FROM Jour  LEFT JOIN Message ON Jour.`#dvalue`=Message.dValue  WHERE Jour.idJour=1" );
$monjour1 = ($jour1->fetch(PDO::FETCH_ASSOC));

$j1 = array(
    "jour" => $monjour1['jour'],
    "dvalue" => $monjour1['#dvalue'],
    "generation fichier" => $monjour1['generationFichier'],
    "message" => $monjour1['message'],
);


// Les données du jour 2
$jour2 = $bd ->query("SELECT Jour.jour,Jour.idJour,Jour.`#dvalue`,Jour.generationFichier,Message.message FROM Jour  LEFT JOIN Message ON Jour.`#dvalue`=Message.dValue  WHERE Jour.idJour=2" );
$monjour2 = ($jour2->fetch(PDO::FETCH_ASSOC));

$j2 = array(
    "jour" => $monjour2['jour'],
    "dvalue" => $monjour2['#dvalue'],
    "generation fichier" => $monjour2['generationFichier'],
    "message" => $monjour2['message'],
);


// Les données du jour 3
$jour3 = $bd ->query("SELECT Jour.jour,Jour.idJour,Jour.`#dvalue`,Jour.generationFichier,Message.message FROM Jour  LEFT JOIN Message ON Jour.`#dvalue`=Message.dValue  WHERE Jour.idJour=3" );
$monjour3 = ($jour3->fetch(PDO::FETCH_ASSOC));

$j3 = array(
    "jour" => $monjour3['jour'],
    "dvalue" => $monjour3['#dvalue'],
    "generation fichier" => $monjour3['generationFichier'],
    "message" => $monjour3['message'],
);


// Mise en forme
$tableau = array(
    "Jour0" => $j0,
    "Jour1" => $j1,
    "Jour2" => $j2,
    "Jour3" => $j3,
);

// Transformation en JSON
echo json_encode($tableau);
?>
