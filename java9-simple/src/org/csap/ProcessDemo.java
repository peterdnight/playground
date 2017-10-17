package org.csap;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

public class ProcessDemo {
	
	static Logger logger = Logger.getLogger(  ProcessDemo.class.getName() );

	public static void main ( String[] args ) {
		// TODO Auto-generated method stub

		System.out.println( "hi" );
		logger.info( "Java native logger" );

		dumpProcessInfo( ProcessHandle.current() );

		ProcessHandle.allProcesses()
			.filter( ph -> ph.info().command().isPresent() )
			.limit( 4 )
			.forEach( ( process ) -> dumpProcessInfo( process ) );
		
	}

	static void dumpProcessInfo ( ProcessHandle ph ) {
		
		StringBuilder processInformation = new StringBuilder() ;
		processInformation.append( "\n\t PROCESS INFORMATION\n" );
		processInformation.append( "\t ===================\n" );
		
		
		processInformation.append( String.format( "\t Process id: %d%n", ph.pid() ) );
		
		
		
		ProcessHandle.Info info = ph.info();
		processInformation.append( String.format( "\t Command: %s%n", info.command().orElse( "" ) ));
		String[] args = info.arguments().orElse( new String[] {} );
		processInformation.append( "\t Arguments:" );
		for ( String arg : args )
			processInformation.append( 
				String.format( "\t\t %s%n", arg ));
			
		processInformation.append( 
			String.format( 
				"\t Command line: %s%n", info.commandLine().orElse( "" ) ));
		
		processInformation.append( String.format( "\t Start time: %s%n",
			info.startInstant().orElse( Instant.now() ).toString() ));
		
		processInformation.append( String.format( "\t Run time duration: %sms%n",
			info.totalCpuDuration()
				.orElse( Duration.ofMillis( 0 ) ).toMillis() ));
		
		processInformation.append( String.format( "\t Owner: %s%n", info.user().orElse( "" ) ));
		
		

		logger.info( processInformation.toString() );
		
	}

}
