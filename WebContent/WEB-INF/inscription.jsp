<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="fr-FR">
<head>
  <meta charset="utf-8"/>
  <link  type="text/css" href="resources/css/Naakon.css" rel="stylesheet"/>
  <Title>MR Fromage</Title>
</head>
<body>
<!-- bandeau horizontal -->
	<c:import url="lib/bandeauh.jsp"></c:import>

	<!-- bandeau vertical -->
	<c:import url="lib/bandeauv.jsp"></c:import>

	<!-- page -->
	<div class="page">
	<div class="titrep">Inscription</div>
	
	<div>

            <form method="post" action="inscription" Class="inscr">

                <fieldset>

                    <legend>Informations client</legend>

    

                    <label for="pseudo">Pseudo <span class="requis">*</span></label>

                    <input type="text" id="pseudo" name="pseudo" value="<c:out value="${ form.pseudo }"/>" size="20" maxlength="20" />

                    <br />
                    
                    
                    <label for="pwd">Mot de passe  <span class="requis">*</span></label>
                    
                    <input type="password" id="pwd" name="pwd" value="<c:out value="${ form.pwd }"/>" size="20" maxlength="20" />
                    
                    <br/>
                    
                    <label for="pwd2">Confirmation du mot de passe  <span class="requis">*</span></label>
                    
                    <input type="password" id="pwd2" name="pwd2" value="<c:out value="${ form.pwd2 }"/>" size="20" maxlength="20" />
                    
                    <br/>
                    

                    <label for="prenom">Prénom </label>
                    
                    <bbr />

                    <input type="text" id="prenom" name="prenom" value="<c:out value="${ form.prenom }"/>" size="20" maxlength="20" />

                    <br />

    

                    <label for="nom">Nom </label>

                    <input type="text" id="nom" name="nom" value="<c:out value="${ form.nom }"/>" size="20" maxlength="20" />

                    <br />
                    

                    <label for="email">Adresse email <span class="requis">*</span></label>

                    <input type="email" id="email" name="email" value="<c:out value="${ form.email }"/>" size="20" maxlength="60" />

                    <br />

                </fieldset>
                
				<div Class="erreur"> ${ form.erreurs }</div>
				
                <input type="submit" value="Valider"  />

                <input type="reset" value="Remettre à zéro" /> <br />

            </form>
		
        </div>
		<a Class="bandeaub" href="http://jigsaw.w3.org/css-validator/check/referer">
		<img style="border:0;width:88px;height:31px"
			src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
			alt="CSS Valide !" />
	</a>
	</p>
	</div>
</body>
</html>
