package com.hivemq.util;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class FileFragmentUtilTest {

    @Test
    public void testRender() throws Exception {
        final Path fragment = Files.createTempFile("fragment", ".xml");

        Files.writeString(fragment, "THE FRAGMENT");
        final String fragmented = "<hallo>${FRAGMENT:" + fragment.toFile() + "}</hallo>";
        final String resolved = FileFragmentUtil.replaceFragmentPlaceHolders(fragmented);

        assertThat(resolved).isEqualTo("<hallo>THE FRAGMENT</hallo>");
    }
}
