<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>TekDays - The Community is the Conference!</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<div id="welcome">
			<br />
			<h3>Welcome to TekDays.com</h3>
			<p>TekDays.com is a site dedicated to assisting individuals and
				communities to organize technology conferences. To bring great
				minds with common interests and passions together for the good
				of greater geekdom!</p>
		</div>
		<div class="homeCell">
			<h3>Find a Tek Event</h3>
			<p> See if there's a technical event in the works that strikes your
					fancy. If there is, you can volunteer to help or just let the
					organizers know that you'd be interested in attending.
					Everybody has a role to play.</p>
			<span class="buttons" >
				<g:link controller="tekEvent" action="index">Find a Tek Event</g:link>
			</span>
		</div>
		<div class="homeCell">
			<h3>Organize a Tek Event</h3>
			<p>If you don't see anything that suits your interest and location,
				then why not get the ball rolling. It's easy to get started and
					there may be others out there ready to get behind you to make it
					happen.</p>
			<span class="buttons" >
				<g:link controller="tekEvent" action="create"> Organize a Tek Event</g:link>
			</span>
		</div>
		<div class="homeCell">
			<h3>Sponsor a Tek Event</h3>
			<p>If you are part of a business or organization that is involved in
				technology then sponsoring a tek event would be a great way to
				let the community know that you're there and you're involved.</p>
			<span class="buttons" >
				<g:link controller="sponsor" action="create">Sponsor a Tek Event</g:link>
			</span>
		</div>
	</body>
</html>