package com.sdr.metadata.service.http;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.CurateServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.CurateSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.Curate}, that is translated to a
 * {@link com.sdr.metadata.model.CurateSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author jaesung
 * @see CurateServiceHttp
 * @see com.sdr.metadata.model.CurateSoap
 * @see com.sdr.metadata.service.CurateServiceUtil
 * @generated
 */
public class CurateServiceSoap {
}
