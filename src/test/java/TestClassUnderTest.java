import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class TestClassUnderTest {

    @Test
    @PrepareForTest(mockForTest.class)
    public void testCallPrivateMethod() throws Exception {

        mockForTest underTest = PowerMockito.mock(mockForTest.class);

        PowerMockito.when(underTest.callPrivateMethod()).thenCallRealMethod();

        PowerMockito.when(underTest, "isExist").thenReturn(true);

        Assert.assertTrue(underTest.callPrivateMethod());

    }

}
