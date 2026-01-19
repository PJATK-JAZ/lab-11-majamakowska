package com.westeros.diagnostics.runners;

import com.westeros.diagnostics.services.contract.Diagnostics;

import java.util.List;

@org.springframework.stereotype.Service
@lombok.RequiredArgsConstructor
public class DiagnosticsRunner implements IRunDiagnoses {

    private final List<IDiagnose> diagnostics;

    @Override
    public List<Diagnostics> runAll() {
        return diagnostics.stream().map(IDiagnose::run).toList();
    }
}
