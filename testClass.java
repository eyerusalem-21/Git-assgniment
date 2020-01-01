package Currency; 
import static org.junit.Assert.*; 
import org.junit.Before; 
import org.junit.Test; 
public class CurrencyTest { 
@Test 
public void testGetByCurrencyCode() { 
  Currency c1= new Currency(); 
  int result=c1.getByCurrencyCode(USD);
  assertEquals(getByCurrencyCode,result); 
 } 
}
